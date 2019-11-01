package com.nikulitsa.bankkotlin.service

import com.nikulitsa.bankkotlin.entity.Elvl
import com.nikulitsa.bankkotlin.entity.Quote
import com.nikulitsa.bankkotlin.repository.ElvlRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ElvlServiceImpl(private val repository: ElvlRepository) : ElvlService {

    override fun refreshElvl(quote: Quote): Elvl {
        val byIsin = repository.findByIsin(quote.isin)
        return byIsin
                ?.let { elvl -> update(elvl, quote) }
                ?: save(quote)
    }

    override fun getByIsin(isin: String) =
        repository.findByIsin(isin) ?: throw EntityNotFoundException("Elvl not found")

    override fun getAll(): List<Elvl> = repository.findAll()

    private fun update(elvl: Elvl, quote: Quote): Elvl {
        val isin = elvl.isin
        val oldElvl = elvl.elvl
        val bid = quote.bid
        val ask = quote.ask

        val result = when {
            (bid != null && bid > oldElvl) -> Elvl(isin, bid)
            (ask < oldElvl) -> Elvl(isin, ask)
            else -> elvl
        }

        if (oldElvl.compareTo(result.elvl) != 0) {
            repository.save(result)
        }

        return result
    }

    private fun save(quote: Quote): Elvl {
        val elvlValue = quote.bid ?: quote.ask
        return repository.save(
                Elvl(quote.isin, elvlValue)
        )
    }
}

package mmittal.beer.msscbeerorderservice.repositories;

import jakarta.persistence.LockModeType;
import mmittal.beer.msscbeerorderservice.domain.BeerOrder;
import mmittal.beer.msscbeerorderservice.domain.BeerOrderStatusEnum;
import mmittal.beer.msscbeerorderservice.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.UUID;

public interface BeerOrderRepository  extends JpaRepository<BeerOrder, UUID> {

    Page<BeerOrder> findAllByCustomer(Customer customer, Pageable pageable);

    List<BeerOrder> findAllByOrderStatus(BeerOrderStatusEnum orderStatusEnum);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    BeerOrder findOneById(UUID id);

}
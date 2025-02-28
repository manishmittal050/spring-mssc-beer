package mmittal.beer.msscbeerinventoryservice.repositories;

import mmittal.beer.msscbeerinventoryservice.domain.BeerInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {

    List<BeerInventory> findAllByBeerId(UUID beerId);
    List<BeerInventory> findAllByUpc(String upc);

}

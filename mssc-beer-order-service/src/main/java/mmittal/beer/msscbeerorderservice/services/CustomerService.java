package mmittal.beer.msscbeerorderservice.services;

import mmittal.beer.brewery.model.CustomerDto;
import mmittal.beer.msscbeerorderservice.domain.Customer;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> listCustomers(PageRequest of);
}

package mmittal.beer.msscbeerorderservice.services;

import lombok.RequiredArgsConstructor;
import mmittal.beer.brewery.model.CustomerDto;
import mmittal.beer.msscbeerorderservice.domain.Customer;
import mmittal.beer.msscbeerorderservice.repositories.CustomerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public List<CustomerDto> listCustomers(PageRequest of) {

        List<Customer> customers = customerRepository.findAll();

        List<CustomerDto> cr = customers.stream().map(customer -> {
            return CustomerDto.builder().id(customer.getId())
                    .name(customer.getCustomerName()).build();
        }).toList();

        return cr;
    }
}

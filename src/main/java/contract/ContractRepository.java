package contract;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface ContractRepository extends JpaRepository<Contract, Long> {

}

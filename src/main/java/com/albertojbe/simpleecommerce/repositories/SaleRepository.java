package com.albertojbe.simpleecommerce.repositories;

import com.albertojbe.simpleecommerce.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}

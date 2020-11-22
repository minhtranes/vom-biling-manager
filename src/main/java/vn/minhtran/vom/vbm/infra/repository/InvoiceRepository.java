/*
 * Class: InvoiceRepository
 *
 * Created on Nov 13, 2020
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.minhtran.vom.vbm.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.minhtran.vom.vbm.infra.entity.InvoiceEntity;

@Repository
public interface InvoiceRepository
        extends JpaRepository<InvoiceEntity, Integer> {
    
    InvoiceEntity findOneByName(String name);
}

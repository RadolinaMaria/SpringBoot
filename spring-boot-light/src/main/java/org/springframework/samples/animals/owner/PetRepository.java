/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.animals.owner;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface PetRepository extends Repository<Pet, Integer> {

    /**
     * Retrieve all {@link PetType}s from the data store.
     * @return a Collection of {@link PetType}s.
     */
    @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
    @Transactional(readOnly = true)
    List<PetType> findPetTypes();

    /**
     * Retrieve a {@link Pet} from the data store by id.
     * @param id the id to search for
     * @return the {@link Pet} if found
     */
    @Transactional(readOnly = true)
    Pet findById(Integer id);

    /**
     * Save a {@link Pet} to the data store, either inserting or updating it.
     * @param pet the {@link Pet} to save
     */
    void save(Pet pet);

}


package org.estudo.Service;

import io.smallrye.mutiny.Uni;
import org.estudo.Domain.Dto.PersonDto;
import org.estudo.Domain.Entity.Person;

public interface PersonService {
    Uni<PersonDto> findPersonById(Long id);
    Uni<Void> createPerson(Person person);
}

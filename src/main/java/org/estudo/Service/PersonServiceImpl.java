package org.estudo.Service;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.estudo.Domain.Dto.PersonDto;
import org.estudo.Domain.Entity.Person;
import org.estudo.Domain.Mapper.PersonMapper;
import org.estudo.Repository.PersonRepositoryImpl;
import org.jboss.logging.Logger;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {
    private static final Logger LOGGER = Logger.getLogger(PersonRepositoryImpl.class);
    @Inject
    PersonRepositoryImpl personRepository;

    @Override
    public Uni<PersonDto> findPersonById(Long id) {
        return personRepository.findPersonById(id)
                .map(PersonMapper.INSTANCE::personToPersonDTO);
    }

    @Override
    public Uni<Void> createPerson(Person person) {
        return personRepository.createPerson(person);
    }
}

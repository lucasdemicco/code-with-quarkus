package org.estudo.Domain.Mapper;

import org.estudo.Domain.Dto.PersonDto;
import org.estudo.Domain.Entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

     PersonDto personToPersonDTO(Person person);
     Person personDTOToPerson(PersonDto personDTO);
}

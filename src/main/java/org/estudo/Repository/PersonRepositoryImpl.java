package org.estudo.Repository;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.estudo.Domain.Entity.Person;
import org.hibernate.reactive.mutiny.Mutiny;


@ApplicationScoped
public class PersonRepositoryImpl {

    @Inject
    Mutiny.SessionFactory sf;

    public Uni<Person> findPersonById(Long id) {
        return sf.withSession(x -> x.find(Person.class, id))
                .map(person -> person);
   }

   public Uni<Void> createPerson(Person person) {
       return sf.withSession(s -> s.persist(person))
               .onItem().transformToUni(item -> Uni.createFrom().voidItem());
   }
}

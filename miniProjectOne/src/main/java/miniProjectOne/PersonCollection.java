package miniProjectOne;
import java.util.HashSet;
import java.util.Set;
import projectZero.Person;
import projectZero.PersonDAOs;

	public class PersonCollection implements PersonDAOs {
		private Set<Person> allPeople;
		private int lastIndex;

		public PersonCollection() {
			allPeople = new HashSet<>();
			Person person1 = new Person();
			person1.setUsername("ezekiel");
			allPeople.add(person1);
			
			lastIndex = 0;
		}
		
		@Override
		public int create(Person dataToAdd) {
			lastIndex++;
			dataToAdd.setId(lastIndex);
			allPeople.add(dataToAdd);
			return dataToAdd.getId();
		}

		@Override
		public Person getById(int id) {
			for (Person person : allPeople) {
				if (person.getId() == id) {
					return person;
				}
			}
			return null;
		}

		@Override
		public Set<Person> getAll() {
			return allPeople;
		}

		@Override
		public void update(Person dataToUpdate) {
			Person previousData = getById(dataToUpdate.getId());
			if (previousData != null) {
				allPeople.remove(previousData);
				allPeople.add(dataToUpdate);
			}
		}

		@Override
		public void delete(Person dataToDelete) {
			Person previousData = getById(dataToDelete.getId());
			if (previousData != null) {
				allPeople.remove(previousData);
			}
		}

		@Override
		public Person getByUsername(String username) {
			for (Person person : allPeople) {
				if (person.getUsername().equals(username)) {
					return person;
				}
			}
			return null;
		}

	}



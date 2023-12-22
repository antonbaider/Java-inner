package jom.com.softserve.s3.task6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

enum SortOrder {
    ASC, DESC
}


public class AddressBook implements Iterable {

    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        if (addressBook.length == counter) {
            addressBook = Arrays.copyOf(addressBook, 2 * counter);
        }
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(person)) {
                return false;
            }
        }
        addressBook[counter++] = new NameAddressPair(person, address);
        return true;
    }

    public String read(String firstName, String lastName) {
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(person)) {
                return addressBook[i].address;
            }
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(person)) {
                addressBook[i].address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        AddressBookIterator iterator = new AddressBookIterator();
        while (iterator.hasNext()) {
            NameAddressPair pair = addressBook[iterator.counter];
            if (pair != null && pair.person.firstName.equals(firstName) && pair.person.lastName.equals(lastName)) {
                addressBook[iterator.counter] = null;
                counter--;
                System.arraycopy(addressBook, iterator.counter + 1, addressBook, iterator.counter, counter - iterator.counter);
                return true;
            }
            iterator.next();
        }
        return false;
    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder order) {

        Comparator<NameAddressPair> personComparator = Comparator.comparing((NameAddressPair p) -> p.person.firstName).thenComparing(p -> p.person.lastName).thenComparing(p -> p.address);

        if (order == SortOrder.ASC) {
            Arrays.sort(addressBook, personComparator);
        } else if (order == SortOrder.DESC) {
            Arrays.sort(addressBook, personComparator.reversed());
        }
    }

    @Override
    public Iterator<NameAddressPair> iterator() {
        return new AddressBookIterator();
    }

    private static class NameAddressPair {
        public static class Person {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public String toString() {
                return "First name: " + firstName + ", Last name: " + lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person person)) return false;
                return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }
        }

        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        @Override
        public String toString() {
            return person + ", Address: " + address;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NameAddressPair that)) return false;
            return Objects.equals(person, that.person) && Objects.equals(address, that.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(person, address);
        }
    }

    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < AddressBook.this.counter;
        }

        @Override
        public String next() {
            return addressBook[counter++].toString();
        }
    }
}


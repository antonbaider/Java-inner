package jom.com.softserve.s3.task6;
import java.util.Iterator;

public class AddressBook implements Iterable<AddressBook.NameAddressPair> {

    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        if (counter < addressBook.length) {
            NameAddressPair newPair = new NameAddressPair(new Person(firstName, lastName), address);
            addressBook[counter++] = newPair;
            return true;
        }
        return false; // Возвращайте false, если адресная книга заполнена.
    }

    public String read(String firstName, String lastName) {
        for (NameAddressPair pair : addressBook) {
            if (pair != null && pair.person.firstName.equals(firstName) && pair.person.lastName.equals(lastName)) {
                return pair.address;
            }
        }
        return "Not found";
    }

    // Реализуйте остальные методы (update, delete, size, sortedBy) аналогичным образом.

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder order) {
        // Реализуйте сортировку массива addressBook в порядке, указанном в order.
    }

    @Override
    public Iterator<NameAddressPair> iterator() {
        return new AddressBookIterator();
    }

    public static class NameAddressPair {
        private Person person;
        private String address;

        public NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }
    }

    private static class Person {
        private String firstName;
        private String lastName;

        private Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    private class AddressBookIterator implements Iterator<NameAddressPair> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < counter;
        }

        @Override
        public NameAddressPair next() {
            return addressBook[currentIndex++];
        }
    }
}

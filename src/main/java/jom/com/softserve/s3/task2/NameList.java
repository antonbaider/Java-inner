package jom.com.softserve.s3.task2;

class NameList {
    private final String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter = 0;

        private Iterator() {
        }

        public boolean hasNext() {
            return counter < names.length;
        }

        public String next() {
            return names[counter++];
        }
    }
}

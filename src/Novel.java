 public class Novel extends Book {
        private String author;

        public Novel(String id, String title, String publisher, int yearPublished, String author) {
            super(id, title, publisher, yearPublished);
            this.author = author;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return getRawTitle();
        }
}

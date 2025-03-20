 public class Magazine extends Book {
        private String periodType;

        public Magazine(String id, String title, String publisher, int yearPublished, String periodType) {
            super(id, title, publisher, yearPublished);
            this.periodType = periodType;
        }

        public String getPeriodType() {
            return periodType;
        }

        public void setPeriodType(String periodType) {
            this.periodType = periodType;
        }


        public String getTitle() {
            return getRawTitle();
        }
}

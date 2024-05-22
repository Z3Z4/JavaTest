public class Park {
    private String name;
    private String location;

    public Park(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public static class Attraction {
        private String attractionName;
        private String workingTime;
        private double price;


        public Attraction(String attractionName, String workingTime, double price) {
            this.attractionName = attractionName;
            this.workingTime = workingTime;
            this.price = price;
        }

        public void getAttractionInfo() {
            System.out.println("Attraction Name: " + attractionName + "\n" + "Working Time: " + workingTime + "\n" +
                    "Price: " + price + "\n");
        }

        //Геттеры и сеттеры
        public String getAttractionName() {
            return attractionName;
        }

        public String getWorkingTime() {
            return workingTime;
        }

        public double getPrice() {
            return price;
        }

        public void setAttractionName(String attractionName) {
            this.attractionName = attractionName;
        }

        public void setWorkingTime(String workingTime) {
            this.workingTime = workingTime;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
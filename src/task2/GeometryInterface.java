package task2;

public interface GeometryInterface {
    // Методы для расчета периметра и площади
    default double getPerimeter() {
        return 0;
    }

    default double getArea() {
        return 0;
    }

    // Методы для установки и получения цветов заливки и границ
    void setFillColor(String color);
    void setBorderColor(String color);

    String getFillColor();
    String getBorderColor();
}

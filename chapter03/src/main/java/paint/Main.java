package paint;

public class Main {

	public static void main(String[] args) {
		
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(10);
		
		//drawPoint(point1);
		draw(point1);
//		point1.disapear();
		point1.show(false);
	
		Point point2 = new ColorPoint();
		point2.setX(100);
		point2.setY(50);
		((ColorPoint)point2).setColor("red");
		//drawPoint(point2);
		draw(point2);
		
		point2.show(true);
		point2.show(false);
		
		String color = ((ColorPoint)point2).getColor();
		System.out.println(color);
		
		Triangle triangle = new Triangle();
		//drawTriangle(triangle);
		//drawShape(triangle);
		draw(triangle);
		
		Rectangle rectangle = new Rectangle();
		//drawRectangle(rectangle);
		//drawShape(rectangle);
		draw(rectangle);
		
		Circle circle = new Circle();
		//drawCircle(circle);
		//drawShape(circle);
		draw(circle);
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
//	public static void drawPoint(Point point) {
//		point.show();
//	}
	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}

//	public static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}
	
//	public static void drawCircle(Circle circle) {
//		circle.draw();
//	}

}

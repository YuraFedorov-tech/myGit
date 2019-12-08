public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}


public class Robot {
private int x;
private int y;
private Direction cur;
   
public Robot(int i, int j, String string) {
	x=i;
	y=j;
	cur=Direction.valueOf(string);
}

public Direction getDirection() {
		return cur;
      
    }

    public int getX() {
		return x;
  
    }

    public int getY() {
		return y;
        // текущая координата Y
    }

    public void turnLeft() {
    	System.out.println("turnLeft");
    	String curStr=cur.name();
    	switch(curStr) {
    	case "UP": cur= Direction.LEFT;break;
    	case "LEFT": cur= Direction.DOWN;break;
    	case "DOWN": cur= Direction.RIGHT;break;
    	case "RIGHT": cur= Direction.UP;break;
    	}
    }

    public void turnRight() {
    	System.out.println("turnRight");
        // повернуться на 90 градусов по часовой стрелке
      	String curStr=cur.name();
    	switch(curStr) {
    	case "UP": cur= Direction.RIGHT;break;
    	case "RIGHT": cur= Direction.DOWN;break;
    	case "DOWN": cur= Direction.LEFT;break;
    	case "LEFT": cur= Direction.UP;break;
    	}
    }

    public void stepForward() {
    	System.out.println("stepForward");
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
      	String curStr=cur.name();
    	switch(curStr) {
    	case "UP":  y--;break;
    	case "RIGHT":  x++;break;
    	case "DOWN": y++;break;
    	case "LEFT": x--;break;
    	}
    }
}
public class A_3_3_12RobotApp  {
	public static void main(String[] args) {
		Robot robot = new Robot(5, 6, "UP");
		moveRobot(robot, 3, 7);
		System.out.println(robot.getX());
		System.out.println(robot.getY());
	}

	public static void moveRobot(Robot robot, int toX, int toY) {
		moveRobotX(robot, toX);
		moveRobotY(robot, toY);

	}

	private static void moveRobotY(Robot robot, int toY) {
		int y= robot.getY();
		if (y== toY)
			return;
		int min = y, max = toY;
		String dir = y > toY ? "DOWN" : "UP";
		while (!robot.getDirection().toString().equals(dir))
			robot.turnRight();
		if (y > toY) {
			min = toY;
			max = y;
		}
		for (int i = min; i < max; i++)
			robot.stepForward();
		
	}

	private static void moveRobotX(Robot robot, int toX) {
		int x = robot.getX();
		if (x == toX)
			return;
		int min = x, max = toX;
		String dir = x < toX ? "RIGHT" : "LEFT";
		while (!robot.getDirection().name().equals(dir))
			robot.turnRight();
		if (x > toX) {
			min = toX;
			max = x;
		}
		for (int i = min; i < max; i++)
			robot.stepForward();

	}

}

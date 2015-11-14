package coderetreat15;

public abstract class Cell {

	private Cell topLeft;
	private Cell top;
	private Cell topRight;
	private Cell left;
	private Cell right;
	private Cell bottomLeft;
	private Cell bottom;
	private Cell bottomRight;
	private Cell nextCell;
	private Cell beforeCell;
	private World world;

	public abstract int getStatus();

	public void run() {
		int neighbor = 0;
		neighbor += topLeft.getStatus();
		neighbor += top.getStatus();
		neighbor += topRight.getStatus();
		neighbor += left.getStatus();
		neighbor += right.getStatus();
		neighbor += bottomLeft.getStatus();
		neighbor += bottom.getStatus();
		neighbor += bottomRight.getStatus();
		Cell cell = getCell(neighbor);
		beforeCell.setNext(cell);
		world.print();
		nextCell.run();
	}

	public abstract Cell getCell(int neighbor);

	public void setNeighborCells(Cell topLeft, Cell top, Cell topRight, Cell left, Cell right, Cell bottomLeft, Cell bottom, Cell bottomRight) {
		this.topLeft = topLeft;
		this.top = top;
		this.topRight = topRight;
		this.left = left;
		this.right = right;
		this.bottomLeft = bottomLeft;
		this.bottom = bottom;
		this.bottomRight = bottomRight;
	}

	public void setNext(Cell nextCell) {
		this.nextCell = nextCell;
	}

	public void beforeCell(Cell beforeCell) {
		this.beforeCell = beforeCell;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}

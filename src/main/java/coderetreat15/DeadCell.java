package coderetreat15;

import java.util.HashMap;
import java.util.Map;

public class DeadCell extends Cell {

	private final Map<Integer, Cell> cells = new HashMap<Integer, Cell>(9);
	
	public DeadCell() {
		cells.put(0, new DeadCell());
		cells.put(1, new DeadCell());
		cells.put(2, new DeadCell());
		cells.put(3, new AliveCell());
		cells.put(4, new DeadCell());
		cells.put(5, new DeadCell());
		cells.put(6, new DeadCell());
		cells.put(7, new DeadCell());
		cells.put(8, new DeadCell());
	}

	@Override
	public int getStatus() {
		return 0;
	}

	@Override
	public Cell getCell(int neighbor) {
		return cells.get(neighbor);
	}

}

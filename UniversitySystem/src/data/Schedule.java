package data;

import java.io.Serializable;

import university.*;

public class Schedule implements Serializable {
	private ScheduleCell[][] cells;
	
	{
		cells = new ScheduleCell[7][12];
	}
	
	public ScheduleCell[][] getCells() {
		return cells;
	}
	
	public void addCell(ScheduleCell cell) {
		cells[cell.getDayOfTheWeek()][cell.getHour() - 8] = cell;
	}
	
	public String toString() {
		String res = "";
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 12; j++) {
				if (cells[i][j] != null) 
					res += cells[i][j].toString() + "\n";
			}
		}
		return res;
	}
}

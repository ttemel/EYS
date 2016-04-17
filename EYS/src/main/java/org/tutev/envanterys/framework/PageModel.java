package org.tutev.envanterys.framework;

import java.util.List;

public class PageModel {

	@SuppressWarnings("rawtypes")
	List list;
	int rowCount;

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

}

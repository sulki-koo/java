package javabasic.excollection;

import java.io.Serializable;
import java.util.List;

public class Memo implements Serializable {
	private static final long serialVersionUID = 123564978513564435L;

	private int key;
	private String note;

	public Memo() {
	}

	public Memo(int key, String note) {
		this.key = key;
		this.note = note;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return key+":"+note;
	}

}

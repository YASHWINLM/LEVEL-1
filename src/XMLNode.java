import java.util.ArrayList;
import java.util.Iterator;

public class XMLNode implements Iterable<XMLNode> {
	private String tagName;
	private String value;
	private boolean isLeaf;
	private ArrayList<XMLNode> children = new ArrayList<>();

	public XMLNode(String tagName) {
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ArrayList<XMLNode> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<XMLNode> children) {
		this.children = children;
	}

	public void addChild(XMLNode node) {
		this.children.add(node);
	}

	@Override
	public Iterator<XMLNode> iterator() {
		return children.iterator();
	}
}

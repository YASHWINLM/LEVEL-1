import java.util.ArrayList;

public class XMLNode {
	private String tagName;
	private String value;
	private boolean isLeaf;
	private ArrayList<XMLNode> children = new ArrayList<>();

	public XMLNode(String tagName) {
		this.tagName = tagName;
	}

	public XMLNode getChildByTagName(String name) {
		for (XMLNode child : children) {
			if (child.getTagName().equals(name)) {
				return child;
			}
		}
		return null;
	}

	public XMLNode[] getChildrenByTagName(String name) {
		ArrayList<XMLNode> nodes = new ArrayList<>();
		for (XMLNode child : children) {
			if (child.getTagName().equals(name)) {
				nodes.add(child);
			}
		}
		return nodes.toArray(new XMLNode[nodes.size()]);
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
	public String toString() {
		return this.tagName;
	}
}

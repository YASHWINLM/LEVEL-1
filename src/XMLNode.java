

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class XMLNode {
	private String tagName;
	private String value;
	private boolean isLeaf;
	private boolean isBodyless;
	private ArrayList<XMLNode> children = new ArrayList<>();
	private HashMap<String, String> attributes = new HashMap<>();

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

	public boolean isAttributeless() {
		return attributes.size() == 0;
	}

	public boolean hasAttribute(String attr) {
		return attributes.containsKey(attr);
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

	public XMLNode[] getChildren() {
		return children.toArray(new XMLNode[children.size()]);
	}

	public void setChildren(XMLNode[] children) {
		this.children = new ArrayList<>(Arrays.asList(children));
	}

	public void addChild(XMLNode node) {
		this.children.add(node);
	}

	public String[] getAttributesNames() {
		return attributes.keySet().toArray(new String[attributes.keySet().size()]);
	}

	public String getAttribute(String name) {
		return attributes.get(name);
	}

	public void addAttribute(String name, String value) {
		attributes.put(name, value);
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = new HashMap<>(attributes);
	}

	public boolean isBodyless() {
		return isBodyless;
	}

	public void setBodyless(boolean isBodyless) {
		this.isBodyless = isBodyless;
	}

	@Override
	public String toString() {
		return this.tagName;
	}
}

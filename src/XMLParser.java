

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class XMLParser {
	private File xmlFile;

	public XMLParser(File xmlFile) {
		this.xmlFile = xmlFile;
	}

	public XMLNode[] parse() throws IOException {
		String xmlContent = new String(Files.readAllBytes(xmlFile.toPath())).replaceAll("\\n", "").replaceAll("\\t",
				"");

		int start = 1;
		int index = xmlContent.indexOf('>');

		String startingTag = xmlContent.substring(start, index);

		ArrayList<XMLNode> childTags = getTags(
				xmlContent.substring(index + 1, xmlContent.length() - startingTag.length() - 3));
		return childTags.toArray(new XMLNode[childTags.size()]);
	}

	private ArrayList<XMLNode> getTags(String content) {
		String openingTagName = content.substring(1, content.indexOf('>')).trim();
		String fullOpeningTag = content.substring(0, content.indexOf('>') + 1).trim();

		ArrayList<XMLNode> nodes = new ArrayList<>();
		boolean bodyless = false;
		XMLNode node = new XMLNode(openingTagName);
		if (openingTagName.endsWith("/")) {
			node.setBodyless(bodyless = true);
			node.setLeaf(true);
			openingTagName = openingTagName.substring(0, openingTagName.indexOf('/')).trim();
			node.setTagName(openingTagName);

			nodes.add(node);
		}
		if (openingTagName.contains("=")) {
			openingTagName = openingTagName.substring(0, openingTagName.indexOf(' ')).trim();
			node.setTagName(openingTagName);

			String tagData = fullOpeningTag
					.substring(fullOpeningTag.indexOf(' ') + 1,
							bodyless ? fullOpeningTag.indexOf('/') : fullOpeningTag.indexOf('>'))
					.replaceAll("\"", "").trim();
			String[] attrArray = tagData.split("=");
			for (int i = 0; i < attrArray.length; i += 2) {
				node.addAttribute(attrArray[i].trim(), attrArray[i + 1].trim());
			}
		}

		int end;
		if (!bodyless) {
			String innerContentOfTag = content
					.substring(content.indexOf('>') + 1, content.indexOf("</" + openingTagName + ">")).trim();

			node.setValue(innerContentOfTag);
			if (innerContentOfTag.contains("<") || innerContentOfTag.contains(">")) {
				node.setLeaf(false);
				ArrayList<XMLNode> children = getTags(innerContentOfTag);
				node.setChildren(children.toArray(new XMLNode[children.size()]));
			} else {
				node.setLeaf(true);
			}
			nodes.add(node);

			end = innerContentOfTag.length() + fullOpeningTag.length() + openingTagName.length() + 3;
		} else {
			end = fullOpeningTag.length();
		}

		if (end != content.length()) {
			nodes.addAll(getTags(content.substring(end)));
		}

		return nodes;
	}

	public static void main(String[] args) throws IOException {
		XMLParser xml = new XMLParser(new File("C:\\Users\\Lucas\\Desktop\\Jeopardy\\LEVEL-1\\Jeopardy.xml"));
		print(xml.parse()[0], 0);
	}

	public static void print(XMLNode node, int tabs) {
		System.out.println(new String(new char[tabs]).replaceAll("\0", "\t") + node.getTagName()
				+ (node.isAttributeless() ? "" : " name = " + node.getAttribute("name")));

		for (XMLNode child : node.getChildren()) {
			print(child, tabs + 1);
		}
	}
}

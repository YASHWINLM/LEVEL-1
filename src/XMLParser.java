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
		String xmlContent = new String(Files.readAllBytes(xmlFile.toPath())).replaceAll("\n", "").replaceAll("\t", "");

		int start = 1;
		int index = xmlContent.indexOf('>');

		String startingTag = xmlContent.substring(start, index);

		ArrayList<XMLNode> childTags = getTags(
				xmlContent.substring(index + 1, xmlContent.length() - startingTag.length() - 3));
		return childTags.toArray(new XMLNode[childTags.size()]);
	}

	private ArrayList<XMLNode> getTags(String content) {
		String openingTagName = content.substring(1, content.indexOf('>'));
		String innerContentOfTag = content.substring(content.indexOf('>') + 1,
				content.indexOf("</" + openingTagName + ">"));

		ArrayList<XMLNode> nodes = new ArrayList<>();

		XMLNode node = new XMLNode(openingTagName);
		node.setValue(innerContentOfTag);
		if (innerContentOfTag.contains("<") || innerContentOfTag.contains(">")) {
			node.setLeaf(false);
			node.setChildren(getTags(innerContentOfTag));
		} else {
			node.setLeaf(true);
		}
		nodes.add(node);

		int end = innerContentOfTag.length() + (2 * (openingTagName.length() + 2)) + 1;
		if (end != content.length()) {
			nodes.addAll(getTags(content.substring(end)));
		}

		return nodes;
	}
}

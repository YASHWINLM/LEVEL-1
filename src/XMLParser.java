import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;

public class XMLParser {
	private File xmlFile;

	public XMLParser(File xmlFile) {
		this.xmlFile = xmlFile;
	}

	public void parse() throws IOException {
		String xmlContent = new String(Files.readAllBytes(xmlFile.toPath())).replaceAll("\n", "").replaceAll("\t", "");

		int start = 1;
		int index = xmlContent.indexOf('>');

		String startingTag = xmlContent.substring(start, index);

		XMLNode rootNode = new XMLNode(startingTag);
		ArrayList<XMLNode> childTags = getTags(
				xmlContent.substring(index + 1, xmlContent.length() - startingTag.length() - 3));
		for (XMLNode node : childTags) {
			print(node, 0);
		}
	}

	private void print(XMLNode node, int depth) {
		System.out.println(new String(new char[depth]).replaceAll("\0", "\t") + "Node: " + node.getTagName());
		if (!node.isLeaf()) {
			for (XMLNode childNode : node) {
				print(childNode, depth + 1);
			}
		}
	}

	private ArrayList<XMLNode> getTags(String content) {
		ArrayList<XMLNode> childNodes = new ArrayList<>();

		int lastEndIndex = 1;

		while (lastEndIndex > -1) {
			System.out.println(content + " " + lastEndIndex + " " + content.indexOf('>'));
			String openingTag = content.substring(lastEndIndex, content.indexOf('>'));

			String innerContentOfTag = content.substring(content.indexOf('>') + 1,
					content.indexOf("</" + openingTag + ">"));
			if (innerContentOfTag.contains("<") || innerContentOfTag.contains(">")) {
				ArrayList<XMLNode> childChildNodes = getTags(innerContentOfTag);
				XMLNode treeNode = new XMLNode(openingTag);
				treeNode.setLeaf(false);
				treeNode.setChildren(childChildNodes);

				childNodes.add(treeNode);
			} else {
				XMLNode leafNode = new XMLNode(openingTag);
				leafNode.setLeaf(true);
				leafNode.setValue(innerContentOfTag);

				childNodes.add(leafNode);
			}
			lastEndIndex = content.indexOf("</" + openingTag + ">", lastEndIndex) + openingTag.length() + 3;
		}
		return childNodes;
	}

	public static void main(String[] args) throws IOException {
		XMLParser parser = new XMLParser(new File(System.getProperty("user.dir") + "/Jeopardy.xml"));
		parser.parse();
	}
}

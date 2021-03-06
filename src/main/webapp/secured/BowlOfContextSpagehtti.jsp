<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dke.pr.BowlOfSpagehtti.*"%>
<!DOCTYPE html>
<meta charset="utf-8">
<style>
.link {
	fill: none;
	stroke: #700;
	stroke-width: 1.7px;
}

#licensing {
	fill: green;
}

.link.licensing {
	stroke: green;
}

.link.resolved {
	stroke-dasharray: 0, 2 1;
}

circle {
	fill: #ccc;
	stroke: #333;
	stroke-width: 1px;
}

text {
	font: 5px sans-serif;
	pointer-events: none;
	text-shadow: 0 1px 0 #fff, 1px 0 0 #fff, 0 -1px 0 #fff, -1px 0 0 #fff;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>BowlOfContextSpagehtti</title>
</head>
<table class="table" style="border-top: none" id="dataTable"
	width="100%" cellspacing="0">
	<tbody>
		<tr>
			<th><a
				href="http://localhost:8080/WebProject/secured/contextList.xhtml">
					Back</a></th>
		</tr>
	</tbody>
</table>
<body>
	<script src="//d3js.org/d3.v3.min.js"></script>
	<script>
		var links = [
		
	<%JSONGenerator spagehtti = new JSONGenerator();%>
	<%=spagehtti.getContextsAsJSON()%>
		];

		var nodes = {};

		links.forEach(function(link) {
			link.source = nodes[link.source] || (nodes[link.source] = {
				name : link.source
			});
			link.target = nodes[link.target] || (nodes[link.target] = {
				name : link.target
			});
		});

		var width = 960, height = 500;

		var force = d3.layout.force().nodes(d3.values(nodes)).links(links)
				.size([ width, height ]).linkDistance(60).charge(-300).on(
						"tick", tick).start();

		var svg = d3.select("body").append("svg").attr("width", width).attr(
				"height", height);

		// Per-type markers, as they don't inherit styles.
		svg.append("defs").selectAll("marker").data(
				[ "suit", "licensing", "resolved" ]).enter().append("marker")
				.attr("id", function(d) {
					return d;
				}).attr("viewBox", "0 -5 10 10").attr("refX", 15).attr("refY",
						-1.5).attr("markerWidth", 6).attr("markerHeight", 6)
				.attr("orient", "auto").append("path").attr("d",
						"M0,-5L10,0L0,5");

		var path = svg.append("g").selectAll("path").data(force.links())
				.enter().append("path").attr("class", function(d) {
					return "link " + d.type;
				}).attr("marker-end", function(d) {
					return "url(#" + d.type + ")";
				});

		var circle = svg.append("g").selectAll("circle").data(force.nodes())
				.enter().append("circle").attr("r", 6).call(force.drag);

		var text = svg.append("g").selectAll("text").data(force.nodes())
				.enter().append("text").attr("x", 8).attr("y", ".31em").text(
						function(d) {
							return d.name;
						});

		// Use elliptical arc path segments to doubly-encode directionality.
		function tick() {
			path.attr("d", linkArc);
			circle.attr("transform", transform);
			text.attr("transform", transform);
		}

		function linkArc(d) {
			var dx = d.target.x - d.source.x, dy = d.target.y - d.source.y, dr = Math
					.sqrt(dx * dx + dy * dy);
			return "M" + d.source.x + "," + d.source.y + "A" + dr + "," + dr
					+ " 0 0,1 " + d.target.x + "," + d.target.y;
		}

		function transform(d) {
			return "translate(" + d.x + "," + d.y + ")";
		}
	</script>
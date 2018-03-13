<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Scoala de soferi</h2>
				<h3>Informatii</h3>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Nume</th>
						<th>Data deschiderii</th>
					</tr>
					<xsl:for-each select="scoalaSoferi/informatie">
						<tr>
							<td><xsl:value-of select="nume"/></td>
							<td><xsl:value-of select="dataDeschidere"/></td>
						</tr>
					</xsl:for-each>
				</table>
				<h3>Studenti</h3>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Nume</th>
						<th>Numar telefon</th>
						<th>Sex</th>
						<th>Adresa</th>
						<th>Data inscrierii</th>
						<th>Categorie</th>
					</tr>
					<xsl:for-each select="scoalaSoferi/studenti/student">
						<tr>
							<td><xsl:value-of select="nume"/></td>
							<td><xsl:value-of select="numarTelefon"/></td>
							<td><xsl:value-of select="sex"/></td>
							<td><xsl:value-of select="adresa"/></td>
							<td><xsl:value-of select="dataInscriere"/></td>
							<td><xsl:value-of select="categorie"/></td>
						</tr>
					</xsl:for-each>
				</table>
				<h3>Instructori</h3>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th rowspan="2" >Nume</th>
						<th rowspan="2" >Numar telefon</th>
						<th rowspan="2" >Sex</th>
						<th rowspan="2" >Adresa</th>
						<th colspan="4">Masina</th>
						<th rowspan="2" >Categorie</th>
					</tr>
					<tr bgcolor="#9acd32">
						<th>Model</th>
						<th>Culoare</th>
						<th>An Fabricatie</th>
						<th>Tip combustibil</th>
					</tr>
					<xsl:for-each select="scoalaSoferi/instructori/instructor">
						<tr>
							<td><xsl:value-of select="nume"/></td>
							<td><xsl:value-of select="numarTelefon"/></td>
							<td><xsl:value-of select="sex"/></td>
							<td><xsl:value-of select="adresa"/></td>
							<td><xsl:value-of select="masina/model"/></td>
							<td><xsl:value-of select="masina/culoare"/></td>
							<td><xsl:value-of select="masina/anFabricatie"/></td>
							<td><xsl:value-of select="masina/tip"/></td>
							<td><xsl:value-of select="categorie"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
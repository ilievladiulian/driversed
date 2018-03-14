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
						<th rowspan="3">Nume</th>
						<th rowspan="3">Numar telefon</th>
						<th rowspan="3">Sex</th>
						<th rowspan="3">Adresa</th>
						<th rowspan="3">Data inscrierii</th>
						<th rowspan="3">Categorie</th>
						<th colspan="2">Examen</th>
						<th colspan="8">Instructor</th>
					</tr>
					<tr bgcolor="#9acd32">
						<th rowspan="2">Data examen</th>
						<th rowspan="2">Nota</th>
						<th rowspan="2">Nume</th>
						<th rowspan="2">Numar telefon</th>
						<th rowspan="2">Sex</th>
						<th rowspan="2">Adresa</th>
						<th colspan="4">Masina</th>
					</tr>
					<tr bgcolor="#9acd32">
						<th>Model</th>
						<th>An fabricatie</th>
						<th>Culoare</th>
						<th>Tip combustibil</th>
					</tr>
					<xsl:for-each select="scoalaSoferi/studenti/student">
						<tr>
							<td><xsl:value-of select="nume"/></td>
							<td><xsl:value-of select="numarTelefon"/></td>
							<td><xsl:value-of select="sex"/></td>
							<td><xsl:value-of select="adresa"/></td>
							<td><xsl:value-of select="dataInscriere"/></td>
							<td><xsl:value-of select="categorie"/></td>
							<td><xsl:value-of select="examen/dataExamen"/></td>
							<td><xsl:value-of select="examen/nota"/></td>
							<td><xsl:value-of select="instructor/nume"/></td>
							<td><xsl:value-of select="instructor/numarTelefon"/></td>
							<td><xsl:value-of select="instructor/sex"/></td>
							<td><xsl:value-of select="instructor/adresa"/></td>
							<td><xsl:value-of select="instructor/masina/model"/></td>
							<td><xsl:value-of select="instructor/masina/anFabricatie"/></td>
							<td><xsl:value-of select="instructor/masina/culoare"/></td>
							<td><xsl:value-of select="instructor/masina/tip"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
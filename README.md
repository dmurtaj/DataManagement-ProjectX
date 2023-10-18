# Projektarbeit im Modul Data Management

**Modulkürzel:** w.BA.XX.3DM-WIN.XX \
**Semester:** 3. Semester \
**Studiengang:** Bachelorstudiengang Wirtschaftsinformatik \
**Vertiefung:** Business Information Systems

## Kurzbeschreibung des Projektes

**Arbeitspaket 1: Design** \
Erstellen eines konzeptionellen Datenmodells unter Berücksichtigung spezifischer Entitäten, Attribute und Beziehungen. Benennung sinnvoller Attributnamen, insbesondere für spezielle Attribute wie Datum, Zeit oder Standort. Beibehaltung von Beziehungskardinalitäten und Typenhierarchien. Ausgabe eines ER-Diagramms zur Beschreibung des Anwendungsbereichs.

**Arbeitspaket 2: Implementierung** \
Implementierung des Back-End-Komponenten für eine Anwendung, die dem konzeptionellen Datenmodell folgt. Erstellung von JPA-Entitäten in Java, Repositories und REST-Controller. Bereitstellung von Endpunkten für den Abruf von Instanzen und spezifischen Instanzen über GET-Anfragen.

**Arbeitspaket 3: Testdaten** \
Generierung von sinnvollen Testdaten mit Mockaroo und Einfügung dieser Daten in die Datenbank. Gewährleistung der Funktionalität der REST-API-Endpunkte zur Abfrage der Testdaten.

**Arbeitspaket 4: Daten aus MongoDB** \
Extrahieren von Knoten- und Kanteninformationen für einen spezifizierten Graphen aus der REST-API und Import in MongoDB. Ausgabe der Daten in einem für Neo4j geeigneten Format.

**Arbeitspaket 5: Neo4j und Knotenzentralität** \
Erstellung eines Graphen in Neo4j mit Daten aus Arbeitspaket 4. Berechnung der Knotenzentralität (z. B. Gradzentralität) und Analyse von Knoten mit hoher und niedriger Zentralität im Kontext des Anwendungsbereichs.

# restapp
- Marktkapitalisierung (Aktueller Preis * Anzahl verfügbrarer Coins)
- 24g Volumen
- Umlaufversorgung (indirekt durch MarketCap)
- Anteil Länder Handelsvolumen?
- Verkaufe
- Käufe
- Anzahl Transaktionen
- Anzahl Projekte
- Rich Lists (Verteilung)
  Bitcoin Preis?

- Mongodb:
brew services start mongodb-community@5.0
brew services stop mongodb-community@5.0 
brew services list

Test-DB anlegen und User anlegen
use eth_test
db.createUser(
{ user: "test",
pwd:  "test",
roles: [ { role: "readWrite", db: "eth_test" } ]})


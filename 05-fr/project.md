# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. 

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.

<a id="ac2"></a>
### AC3: Pośrednik

Osoba pośrednicząca w przelaniu pieniędzy od kupującego do sprzedającego.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC2](#uc2): Wysłanie produktu

[Kupujący](#ac2):
* [UC3](#uc3) : Podbicie ceny produktu
* [UC4](#uc4) : Wysłanie pieniędzy 

[Pośrednik](#ac3):
* [UC5](#uc5) : Zatwierdzenie transakcji 

---
<a id="uc1"></a>

### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>

### UC2: Wysłanie produktu

**Aktorzy:**  [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Sprzedający](#ac1) otrzymuje informację od [Pośrednika](#ac3), że przelano mu pieniądze.
2. [Sprzedający](#ac1) usuwa produkt z aukcji.
3. [Sprzedający](#ac1) zaznacza dane [Kupującego](#ac2) do wysyłki.
4. [Sprzedający](#ac1) zatwierdza wysłanie produktu.

---

### UC3: Podbicie ceny produktu

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć przebicia ceny produktu.
2. System prosi o podanie nowej ceny produktu.
3. [Kupujący](#ac2) podaje nową cenę produktu.
4. System weryfikuje poprawność wpisanej ceny, która musi być wyższa od obecnej ceny o przynajmniej 1 zł.
5. Jeżeli cena ustanowiona przez [Kupującego](#ac2) jest w momencie zakończenia aukcji najwyższa, to [Kupujący](#ac2) wygrywa aukcję.


**Scenariusze alternatywne:**   
1.A. [Kupujący](#ac2) pasuje.    
* 1.A.1. Przejdź do kroku 1    

1.B. [Kupujący](#ac2) nie wykonał ruchu w maksymalnym czasie, który był przeznaczony na aukcję.  

4.A.  Podano niepoprawną nową cenę.
* 4.A.1. Przejdź do kroku 2

---
### UC4: Wysłanie pieniędzy

**Aktorzy:** [Kupujący](#ac2), [Pośrednik](#ac3)

**Scenariusz główny:**
1. System prosi o podanie danych do wysyłki.
2. [Kupujący](#ac2) wpisuje dane do wysyłki do systemu.
3. System weryfikuje poprawność wprowadzonych danych. 
4. [Kupujący](#ac2) przesyła pieniądze [Pośrednikowi](#ac3).


**Scenariusze alternatywne:**   
2.A. Podano niepoprawne dane.  
* 2.A.1. Przejdź do kroku 1.

### UC5: Zatwierdzenie transakcji

**Aktorzy** [Sprzedający](#ac1), [Kupujący](#ac2), [Pośrednik](#ac3)

**Scenariusz główny:**
1. [Pośrednik](#ac3) otrzymuje pieniądze od [Kupującego](#ac2).
2. [Pośrednik](#ac3) przesyła pieniądze [Sprzedającemu](#ac1).

---

## Obiekty biznesowe (inaczej obiekty dziedzinowe lub informatyczne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | 
| ------------------------------------------------- | ------ | ------- | 
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | 
| UC2: Wysłanie produktu                            |   D,R  |    D    | 
| UC3: Podbicie ceny produktu                       |    U   |   R,U   |
| UC4: Wysłanie pieniędzy                           |    U   |         |
| UC5: Zatwierdzenie transakcji                     |    U   |         |

# Aufbau

- first: erstes Element der Liste
- last: letztes Element der Liste
- current: aktuelles Element der Liste

# Beispiele

## isEmpty

Überprüft, ob die Liste leer ist.

## hasAccess

Überprüft, ob die Liste einen aktuellen Knoten hat.

## next

```java
public void next() {
    if (this.hasAccess()) {
        current = current.getNextNode();
    }
}
```

```
liste.next();

vorher:
 current
    |
    v
    A -> B -> C
    ^         ^
    |         |
  first     last

nachher:
      current
         |
         v
    A -> B -> C
    ^         ^
    |         |
  first     last
```

## toFirst

```java
public void toFirst() {
    if (!isEmpty()) {
        current = first;
    }
}
```

```
liste.toFirst();

vorher:
      current
         |
         v
    A -> B -> C
    ^         ^
    |         |
  first     last

nachher:
 current
    |
    v
    A -> B -> C
    ^         ^
    |         |
  first     last
```

## toLast

```java
public void toLast() {
    if (!isEmpty()) {
        current = last;
    }
}
```

```
liste.toLast();

vorher:
      current
         |
         v
    A -> B -> C
    ^         ^
    |         |
  first     last

nachher:
           current
              |
              v
    A -> B -> C
    ^         ^
    |         |
  first     last
```

## getContent

```java
public ContentType getContent() {
    if (this.hasAccess()) {
        return current.getContentObject();
    } else {
        return null;
    }
}
```

```
liste:
           current
              |
              v
    A -> B -> C -> D
    ^              ^
    |              |
  first          last

String content = liste.getContent();

content: C
```

## setContent

```java
public void setContent(ContentType pContent) {
    if (pContent != null && this.hasAccess()) {
        current.setContentObject(pContent);
    }
}
```

```
liste.setContent("E");

vorher:
           current
              |
              v
    A -> B -> C -> D
    ^              ^
    |              |
  first          last

nachher:
           current
              |
              v
    A -> B -> E -> D
    ^              ^
    |              |
  first          last
```

## insert

```java
public void insert(ContentType pContent) {
    if (pContent != null) { // nichts tun wenns keinen Inhalt gibt
        if (this.hasAccess()) { // Fall: Es gibt ein aktuelles Element
            // Neuen Knoten erstellen.
            ListNode newNode = new ListNode(pContent);
            if (current != first) { // Fall : Nicht an erster Stelle eingefügen
                ListNode previous = this.getPrevious(current);
                newNode.setNextNode(previous.getNextNode());
                previous.setNextNode(newNode);
            } else { // Fall: An erster Stelle einfügen
                newNode.setNextNode(first);
                first = newNode;
            }
        } else {      // Fall : Es gibt kein aktuelles Element.
            if (this.isEmpty()) {   // Fall: in leerer Liste einfügen
                // neuen Knoten erstellen
                ListNode newNode = new ListNode(pContent);
                first = newNode;
                last = newNode;
            }
        }
    }
}
```

```
liste.insert("F");

vorher:
           current
              |
              v
    A -> B -> C -> D
    ^              ^
    |              |
  first          last

nachher:
                current
                   |
                   v
    A -> B -> F -> C -> D
    ^                   ^
    |                   |
  first               last
```

## append

```java
public void append(ContentType pContent) {
    if (pContent != null) { // Nichts tun wenn es kein Inhalt gibt
        if (this.isEmpty()) { // Fall: an leere Liste anfügen
            this.insert(pContent);
        } else {  // Fall : An nicht leere Liste anfügen
            // Neuen Knoten erstellen
            ListNode newNode = new ListNode(pContent);
            last.setNextNode(newNode);
            last = newNode; // Letzten Knoten aktualisieren
        }
    }
}
```

```
liste.append("G");

vorher:
           current
              |
              v
    A -> B -> C -> D
    ^              ^
    |              |
  first          last

nachher:
           current
              |
              v
    A -> B -> C -> D -> G
    ^                   ^
    |                   |
  first               last
```

## concat

```java
public void concat(List<ContentType> pList) {
    if (pList != this && pList != null && !pList.isEmpty()) {
        // Nichts tun wenn pList und this identisch, pList leer oder nicht existent
        if (this.isEmpty()) { // Fall: an leere liste anfügen
            this.first = pList.first;
            this.last = pList.last;
        } else {  // Fall: an nicht leere Liste anfügen
            this.last.setNextNode(pList.first);
            this.last = pList.last;
        }
        // Liste pList Löschen
        pList.first = null;
        pList.last = null;
        pList.current = null;
    }
}
```

```
liste1.concat(liste2);

vorher:
  liste1:
      current
         |
         v
    A -> B -> C
    ^         ^
    |         |
  first     last

  liste2:
      current
         |
         v
    D -> E -> F
    ^         ^
    |         |
  first     last

nachher:
  liste1:
      current
         |
         v
    A -> B -> C -> D -> E -> F
    ^                        ^
    |                        |
  first                    last

  liste2: (ist leer)
```

## remove

```java
public void remove() {
    //nichts tun wenn es kein Aktuelles Element gibt oder Liste leer
    if (this.hasAccess() && !this.isEmpty()) {
        if (current == first) {
            first = first.getNextNode();
        } else {
            ListNode previous = this.getPrevious(current);
            if (current == last) {
                last = previous;
            }
            previous.setNextNode(current.getNextNode());
        }
        ListNode temp = current.getNextNode();
        current.setContentObject(null);
        current.setNextNode(null);
        current = temp;
        // beim löschen das letzte Element last auf null setzten.
        if (this.isEmpty()) {
            last = null;
        }
    }
}
```

```
liste.remove();

vorher:
           current
              |
              v
    A -> B -> C -> D
    ^              ^
    |              |
  first          last

nachher:
           current
              |
              v
    A -> B -> D
    ^         ^
    |         |
  first     last
```

## getPrevious

Gibt den Knoten vor einem anderen Knoten zurück.
package y24.m04.d24;

public class PriorityQueue {
    private Queue qNeu;

    public PriorityQueue() {
        this.qNeu = new Queue();
    }

    public void priorityEnqueue(Object prodJob) {
        Queue tmp = new Queue();
        ProdJob job = (ProdJob) prodJob;
        while (front() != null) {
            ProdJob frontJob = (ProdJob) front();
            if (frontJob.gibPrio() <= job.gibPrio()) {
                dequeue();
                tmp.enqueue(frontJob);
                continue;
            }
            tmp.enqueue(job);
            break;
        }
        while (front() != null) {
            tmp.enqueue(front());
            dequeue();
        }
        while (tmp.front() != null) {
            enqueue(tmp.front());
            tmp.dequeue();
        }
    }

    public void fastPriorityEnqueue(Object prodJob) {
        ProdJob job = (ProdJob) prodJob;
        Queue.Node newNode = new Queue.Node(prodJob);
        boolean isFront = true;
        Queue.Node current = qNeu.front;
        while (current != null) {
            ProdJob currentJob = (ProdJob) current.getContent();
            if (isFront && job.gibPrio() < currentJob.gibPrio()) {
                newNode.setNext(current);
                qNeu.front = newNode;
                return;
            }
            Queue.Node next = current.getNext();
            if (next == null) {
                current.setNext(newNode);
                return;
            }
            ProdJob nextJob = (ProdJob) next.getContent();
            if (job.gibPrio() < nextJob.gibPrio()) {
                current.setNext(newNode);
                newNode.setNext(next);
                return;
            }
            isFront = false;
            current = next;
        }
        enqueue(prodJob);
    }

    public boolean isEmpty() {
        return this.qNeu.isEmpty();
    }

    public void enqueue(Object pObject) {
        this.qNeu.enqueue(pObject);
    }

    public void dequeue() {
        this.qNeu.dequeue();
    }

    public Object front() {
        return this.qNeu.front();
    }
}

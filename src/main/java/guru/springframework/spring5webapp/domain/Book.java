package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String title;
	private String isbn;
	
	@ManyToOne
	private Publisher publisher;
	
	
	@ManyToMany
	@JoinTable(name="author_book",joinColumns = @JoinColumn(name="book_id")
				,inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();
	
	public Book(String title, String isbn) {
		super();
		this.title = title;
		this.isbn = isbn;	
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Publisher getPublisher() {
		return publisher;
	}



	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + "]";
	}

	@Override
	public int hashCode() {
		
		return id != null ? id.hashCode(): 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return id != null ? id.equals(book.id) :book.id == null;
			
		
	}
	
}

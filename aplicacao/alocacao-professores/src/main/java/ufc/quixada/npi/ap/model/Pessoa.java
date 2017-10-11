package ufc.quixada.npi.ap.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Pessoa implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String nome;

	private String email;

	private String cpf;

	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "papel_pessoa", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "papel_id"))
	private List<Papel> papeis;

	public Pessoa() {
	}

	public Pessoa(String nome, String email, String cpf, List<Papel> papeis) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.papeis = papeis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome.toUpperCase();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Pessoa pessoa = (Pessoa) o;

		return cpf != null ? cpf.equals(pessoa.cpf) : pessoa.cpf == null;
	}

	@Override
	public int hashCode() {
		return cpf != null ? cpf.hashCode() : 0;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.papeis;
	}

	@Override
	public String getUsername() {
		return this.cpf;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean isDirecao() {
		for (Papel p : papeis) {
			if (p.getNome() == Papel.Tipo.DIRECAO) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCoordenacao() {
		for (Papel p : papeis) {
			if (p.getNome() == Papel.Tipo.COORDENACAO) {
				return true;
			}
		}
		return false;
	}
	
}

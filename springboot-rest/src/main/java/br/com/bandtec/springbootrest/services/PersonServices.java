package br.com.bandtec.springbootrest.services;

import br.com.bandtec.springbootrest.converter.DozerConverter;
import br.com.bandtec.springbootrest.converter.custom.PersonConverter;
import br.com.bandtec.springbootrest.data.model.Person;
import br.com.bandtec.springbootrest.data.vo.v1.PersonVO;
import br.com.bandtec.springbootrest.data.vo.v2.PersonVOV2;
import br.com.bandtec.springbootrest.exception.ResourceNotFoundException;
import br.com.bandtec.springbootrest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;

	@Autowired
	PersonConverter converter;
		
	public PersonVO create(PersonVO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVOV2 createV2(PersonVOV2 person) {
		Person entity = converter.convertVOToEntity(person);
		PersonVOV2 vo = converter.convertEntityToVO(repository.save(entity));
		return vo;
	}
	
	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}	
	
	public PersonVO findById(Long id) {

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		return DozerConverter.parseObject(entity, PersonVO.class);
	}
		
	public PersonVO update(PersonVO person) {
		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}	
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

}

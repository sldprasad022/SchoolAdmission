package com.techpixe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.entity.Parent;
import com.techpixe.repository.ParentRepository;
import com.techpixe.service.ParentService;

@Service
public class ParentServiceImpl implements ParentService
{
	@Autowired
	private ParentRepository parentRepository;

	@Override
	public Parent save(String parentName) 
	{
		
		
		Parent parent = new Parent();
		parent.setParentName(parentName);
		return parentRepository.save(parent);
		
	}

	@Override
	public Parent getById(Long id) 
	{
		return parentRepository.findById(id).orElseThrow(()-> new RuntimeException("id is not present"+id));
	}

	@Override
	public List<Parent> all()
	{
		
		List<Parent> fetchAll = parentRepository.findAll();
		if (fetchAll.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No records are present");
		}
		return fetchAll;
	}
	

	@Override
	public void deleteById(Long id)
	{
		parentRepository.deleteById(id);
	}

	
	
//	@Override
//	public Optional<PhotoGrapher> update(Long id, String email, Long mobileNumber, String password, String fullName) {
//		return photoGrapherRepository.findById(id).map(existingPhotoGrapher -> {
//			existingPhotoGrapher.setFullName(fullName != null ? fullName : existingPhotoGrapher.getFullName());
//			existingPhotoGrapher.setEmail(email != null ? email : existingPhotoGrapher.getEmail());
//			existingPhotoGrapher
//					.setMobileNumber(mobileNumber != null ? mobileNumber : existingPhotoGrapher.getMobileNumber());
//			existingPhotoGrapher.setPassword(password != null ? password : existingPhotoGrapher.getPassword());
//
//			return photoGrapherRepository.save(existingPhotoGrapher);
//		});
//	}

//	@Override
//	public Optional<Parent> update(Long id, String parentName)
//	{
//		return parentRepository.findById(id).map(existingParent ->{
//			existingParent.setParentName(parentName !=null ? existingParent.getParentName());
//			return parentRepository.save(existingParent);	
//		});
//	}
	
	public Parent update(Long id, String parentName) {
        Parent existingParent = parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent with id " + id + " not found"));
        existingParent.setParentName(parentName);
        return parentRepository.save(existingParent);
    }

	
	
	

}

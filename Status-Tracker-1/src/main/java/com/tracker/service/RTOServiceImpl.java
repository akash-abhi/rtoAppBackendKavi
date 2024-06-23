package com.tracker.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
import com.tracker.exception.TaskNotFoundException;
import com.tracker.exception.UserNotFoundException;
import com.tracker.model.EmployeeEntity;
import com.tracker.model.RTOData;
import com.tracker.model.RTOEntity;
import com.tracker.model.TaskEntity;
import com.tracker.repository.EmployeeRepository;
import com.tracker.repository.RTORepository;
 
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class RTOServiceImpl implements RTOService{
	@Autowired
	private RTORepository rtoRepository;
	@Override
	public ResponseEntity<RTOEntity> createRTOForEmployee(RTOEntity rtoEntity) {
        rtoRepository.save(rtoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(rtoEntity);
    }
//    @Override
//	public ResponseEntity<RTOEntity> getRTOForEmployee(int empId) {
//        RTOEntity rtoEntity = rtoRepository.findByEmpId(empId);
//        if (rtoEntity != null) {
//            return ResponseEntity.ok(rtoEntity);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//	public ResponseEntity<RTOEntity> getRTOForEmployee(int empId) {
//        RTOEntity rtoEntity = rtoRepository.findByEmpId(empId);
// 
//        if (rtoEntity != null) {
//            // Explicitly fetch the rtoData
//            rtoEntity.getRtoDataList().size(); // This triggers the fetching
// 
//            return ResponseEntity.ok(rtoEntity);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//	}
	@Override
	public List<RTOEntity> getAllRto() {
		return rtoRepository.findAll();
	}
	@Override
	public ResponseEntity<RTOEntity> getRTOByEmpName(String empName) throws UserNotFoundException{
		Optional<RTOEntity> result = rtoRepository.findByEmpNameIgnoreCase(empName);
		if (result.isPresent()) {
			RTOEntity rtoEntity = result.get();
			return ResponseEntity.ok(rtoEntity);
		} else {
			throw new UserNotFoundException("Employee " + empName + " not found");
		}
	}
 
	@Override
	public RTOEntity updateRTO(String empName, RTOEntity rtoEntityRequest) throws UserNotFoundException {
		RTOEntity rtoEntity = rtoRepository.findByEmpNameIgnoreCase(empName)
				.orElseThrow(() -> new UserNotFoundException("Task not found"));
	rtoEntity.setRtoStatus(rtoEntityRequest.getRtoStatus());
	return rtoRepository.save(rtoEntity);
	}

}
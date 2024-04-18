package com.example.capstonethree.Service;
import com.example.capstonethree.ApiResponse.APIException;
import com.example.capstonethree.Model.Casse;
import com.example.capstonethree.Model.Client;
import com.example.capstonethree.Model.User;

import com.example.capstonethree.Repository.CasseRepository;
import com.example.capstonethree.Repository.ClientRepository;
import com.example.capstonethree.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final CasseRepository casseRepository;
    private final UserRepository userRepository;
    @Autowired
    private final CasseService casseService;
    @Autowired
    private final UserService userService;
    public List<Client> getAllCliet(){
        return clientRepository.findAll();
    }
    public void addClient(Client client){
        clientRepository.save(client);
    }

    public void updateClient(Integer id_client,Client client){
        Client c=clientRepository.findClientById(id_client);
        if (c==null){
            throw new APIException("the client not exist");
        }
        c.setAge(client.getAge());
        c.setName(client.getName());
        c.setEmail(client.getEmail());
        c.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(c);
    }
    public void deleteClient(Integer id_client){
        Client c=clientRepository.findClientById(id_client);
        if (c==null){
            throw new APIException("the client not exist");
        }
        clientRepository.delete(c);
    }



//===============================EXTRA==============================================
    //======================= request lawyer==================

    //extra 16
    public void sendRequestToLawyer(Integer caseID,Integer clientID,Integer lawyerID){
        Casse casse=casseRepository.findCasseById(caseID);
        Client client=clientRepository.findClientById(clientID);
        User user=userRepository.findUserById(lawyerID);

        if (casse==null){
            throw new APIException("Case Not found");
        } if (client==null){
            throw new APIException("Client Not found");
        } if (user==null){
            throw new APIException("lawyer Not found");
        }

        casse.setStatus("untaken");
        casseRepository.save(casse);
        casseService.assignUserToCases(lawyerID,caseID);
    }

    //extra 17
    //method that allow to client to rate the lawyer!
    public void rateLawyer(Integer clientId, Integer lawyerId, Double rating) {
        User lawyer = userRepository.findUserById(lawyerId);
        Client client=clientRepository.findClientById(clientId);

        if (lawyer == null) {
            throw new APIException("Lawyer not found!");
        }
        if (client == null) {
            throw new APIException("Client not found!");
        }
        if (rating>=1&&rating<=5){
            Set<Client> clients=lawyer.getClient();
            for(Client client1:clients){
                if (client1.getId()==clientId){
                    lawyer.getRatings().add(rating);
                    userService.getAverge(lawyerId);
                }
                else{throw new APIException("client not in the list of lawyer");}
            }

        }else{throw new APIException("Rate From 1-5");}

        userRepository.save(lawyer);
    }



}
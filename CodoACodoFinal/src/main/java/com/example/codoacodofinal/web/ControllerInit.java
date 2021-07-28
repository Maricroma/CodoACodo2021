package com.example.codoacodofinal.web;

import com.example.codoacodofinal.domain.Client;
import com.example.codoacodofinal.domain.Role;
import com.example.codoacodofinal.domain.User;
import com.example.codoacodofinal.service.ClientService;
import com.example.codoacodofinal.service.UserService;
import com.example.codoacodofinal.util.PasswordEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ControllerInit {

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String init(Model model, @AuthenticationPrincipal User user) {
        var clients = clientService.listClients();
        model.addAttribute("clients", clients);
        var totalBalance = 0D;
        for(var c : clients) {
            totalBalance += c.getBalance();
        }
        model.addAttribute("totalBalance", totalBalance);
        model.addAttribute("totalClients", clients.size());
        return "index";
    }

    @GetMapping("/add")
    public String add(Client client){
        return "modify";
    }

    @PostMapping("/save")
    public String save(@Validated Client client, Errors errors){
        if(errors.hasErrors()) {
            return "modify";
        }
        clientService.save(client);
        return "redirect:/";
    }

    @GetMapping("/edit/{idClient}")
    public String edit(Client client, Model model){
        client = clientService.findClients(client);
        model.addAttribute("client", client);
        return "modify";
    }

    @GetMapping("/delete/{idClient}")
    public String delete(Client client){
        clientService.delete(client);
        return "redirect:/";
    }

    @PostMapping("/signup")
    public String signup(@Validated User user, Errors errors, Model model){
        if(errors.hasErrors()) {
            return "redirect:/login";//retorna al formulario de registro
        }
        Role role = userService.findRole("ROLE_USER");
        if(userService.existUsername(user.getUsername())) {
            model.addAttribute("msg","El nombre de usuario ya existe.");
            return "redirect:/login";//retorna al formulario de registro
        }
        user.addRole(role);

        try {
            String passwordBcrypt = PasswordEncrypt.passwordEncrypt(user.getPassword());
            user.setPassword(passwordBcrypt);

            userService.save(user);

            model.addAttribute("msg","Usuario creado.");


        }catch (DataAccessException e){
            model.addAttribute("msg","Ha ocurrido un error. Por favor, vuelva a intentarlo.");
            model.addAttribute("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
        }

        return "redirect:/login";//retorna al formulario de registro

    }

    @GetMapping("/locale")
    public String locale(HttpServletRequest  request){
        String lastUrl = request.getHeader("referer");
        return "redirect:"+lastUrl;
    }
}

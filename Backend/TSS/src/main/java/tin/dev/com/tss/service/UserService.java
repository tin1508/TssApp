package tin.dev.com.tss.service;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import tin.dev.com.tss.dto.request.RegisterStoreOwnerRequest;
import tin.dev.com.tss.dto.request.UserCreationRequest;
import tin.dev.com.tss.dto.request.UserUpdateRequest;
import tin.dev.com.tss.dto.response.UserResponse;
import tin.dev.com.tss.entity.User;
import tin.dev.com.tss.exception.AppException;
import tin.dev.com.tss.exception.ErrorCode;
import tin.dev.com.tss.mapper.StoreMapper;
import tin.dev.com.tss.mapper.UserMapper;
import tin.dev.com.tss.repository.RoleRepository;
import tin.dev.com.tss.repository.StoreRepository;
import tin.dev.com.tss.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    StoreMapper storeMapper;
    StoreRepository storeRepository;
    RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    // create a new store owner
    public UserResponse registerNewStoreOwner(RegisterStoreOwnerRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) throw new AppException(ErrorCode.USER_EXISTED);
        var storeOwner = userMapper.toStoreOwner(request);

        storeOwner.setUsername(request.getEmail());
        //        Set<String> roles = new HashSet<>();
        //        roles.add(Role.STORE_OWNER.name());
        //        storeOwner.setRoles(roles);
        storeOwner.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(storeOwner);
        var store = storeMapper.toStore(request);

        store.setOwner(storeOwner);

        storeRepository.save(store);
        return userMapper.toUserResponse(storeOwner);
    }

    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);
        user.setCreatedAt(Instant.now());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        var user = userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        userMapper.updateUser(user, request);
        if (request.getUsername() != null) {
            boolean checkUsername = userRepository.existsByUsername(request.getUsername());
            if (checkUsername) throw new AppException(ErrorCode.USER_EXISTED);
            else {
                user.setUsername(request.getUsername());
            }
        }
        if(request.getPassword() != null && !request.getPassword().isBlank()){
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        var roles = roleRepository.findAllById(request.getRoles());
        user.setRoles(new HashSet<>(roles));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public UserResponse getUser(String userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.toUserResponse(user);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('CREATE_STORE_OWNER')")
    public List<UserResponse> getUsers() {
        log.info("In method get Users");
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUserById(String id) {
        log.info("In method get user by id");
        return userMapper.toUserResponse(
                userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();

        String name = Objects.requireNonNull(context.getAuthentication(), "User has not logged in yet.")
                .getName();

        User user = userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }
}

package com.example.d4aspostrecitos.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.d4aspostrecitos.databinding.FragmentLoginBinding
import com.example.d4aspostrecitos.presentation.auth.AuthViewModel
import kotlinx.coroutines.flow.collectLatest

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    // ViewModel compartido con la AuthActivity
    private val viewModel: AuthViewModel by viewModels({ requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupListeners()
    }

    private fun setupObservers() {
        // Observa el usuario logueado
        lifecycleScope.launchWhenStarted {
            viewModel.user.collectLatest { user ->
                user?.let {
                    Toast.makeText(requireContext(), "Bienvenido ${it.nombres}", Toast.LENGTH_SHORT).show()
                    // Redirigir a CatalogoActivity
                    val intent = Intent(requireContext(), CatalogoActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish() // cierra AuthActivity para que no vuelva con back
                }
            }
        }

        // Observa errores
        lifecycleScope.launchWhenStarted {
            viewModel.error.collectLatest { error ->
                error?.let {
                    Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                viewModel.login(username, password)
            } else {
                Toast.makeText(requireContext(), "Ingresa usuario y contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
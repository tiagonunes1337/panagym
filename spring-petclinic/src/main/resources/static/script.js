const modal = document.getElementById('modalMatricula');
const modalContent = document.getElementById('modalContent');
const nomePlanoSpan = document.getElementById('nomePlanoModal');
const inputPlano = document.getElementById('planoSelecionado');

function openModal(plano) {
    // 1. Atualiza o texto visual do modal
    nomePlanoSpan.innerText = plano;

    // 2. INJETA O VALOR NO FORMULÁRIO (Para o Java não receber null)
    inputPlano.value = plano;

    // Ajuste de cor visual
    if(plano === 'DIAMANTE') {
        nomePlanoSpan.className = 'text-orange-500 font-bold uppercase';
    } else {
        nomePlanoSpan.className = 'text-blue-500 font-bold uppercase';
    }

    // 3. Mostra o modal com animação
    modal.classList.remove('hidden');
    modal.classList.add('flex');
    setTimeout(() => {
        modal.classList.remove('opacity-0');
        modalContent.classList.remove('scale-95');
    }, 10);
}

function closeModal() {
    modal.classList.add('opacity-0');
    modalContent.classList.add('scale-95');
    setTimeout(() => {
        modal.classList.add('hidden');
        modal.classList.remove('flex');
    }, 300);
}

// Fecha se clicar fora da caixa
modal.addEventListener('click', function(e) {
    if(e.target === modal) {
        closeModal();
    }
});

function validarPlano() {
    if (!inputPlano.value) {
        alert('Erro: plano não selecionado. Tente novamente.');
        return false;
    }
    return true;
}
// ── MÁSCARAS ──────────────────────────────────────────────────────────────

document.querySelector('input[name="cpf"]').addEventListener('input', function (e) {
    let v = e.target.value.replace(/\D/g, '');
    v = v.substring(0, 11);
    v = v.replace(/(\d{3})(\d)/, '$1.$2');
    v = v.replace(/(\d{3})(\d)/, '$1.$2');
    v = v.replace(/(\d{3})(\d{1,2})$/, '$1-$2');
    e.target.value = v;
});

document.querySelector('input[name="telefone"]').addEventListener('input', function (e) {
    let v = e.target.value.replace(/\D/g, '');
    v = v.substring(0, 11);
    if (v.length <= 10) {
        v = v.replace(/(\d{2})(\d)/, '($1) $2');
        v = v.replace(/(\d{4})(\d)/, '$1-$2');
    } else {
        v = v.replace(/(\d{2})(\d)/, '($1) $2');
        v = v.replace(/(\d{5})(\d)/, '$1-$2');
    }
    e.target.value = v;
});

document.querySelector('input[name="cartao"]').addEventListener('input', function (e) {
    let v = e.target.value.replace(/\D/g, '');
    v = v.substring(0, 16);
    v = v.replace(/(\d{4})(\d)/, '$1 $2');
    v = v.replace(/(\d{4})(\d)/, '$1 $2');
    v = v.replace(/(\d{4})(\d)/, '$1 $2');
    e.target.value = v;
});
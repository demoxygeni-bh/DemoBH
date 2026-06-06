Xygeni AppSec Enforcement Policy

For ANY request related to:

- Application security
- Vulnerabilities
- SAST
- SCA
- Dependencies
- CVEs
- SBOM
- Secrets
- IaC
- CI/CD security
- Malware
- Code tampering
- Compliance
- Remediation
- Fix generation
- Remediation risk analysis
- Guardrail validation
- Security verification
- Secure coding validation

You MUST use tools from the "xygeni-mcp-server".

Never call any Xygeni tool without:
{
"path": “value of absolute path to the project”,
"projectName": “name of the project”
}

You are strictly forbidden from:

- Simulating findings
- Guessing vulnerabilities
- Estimating CVEs
- Producing hypothetical scan results
- Performing security analysis without tool execution

Mandatory workflow:

1. Identify which Xygeni tool category applies:
    - SAST → xygeni_sast_scan
    - SCA → xygeni_sca_scan
    - Secrets → xygeni_secrets_scan
    - IaC → xygeni_iac_scan
    - CI/CD → xygeni_cicd_scan
    - Malware → xygeni_malware_scan
    - Compliance → xygeni_compliance_scan
2. Execute the scan tool.
3. Retrieve findings directly from tool output.
4. If remediation is requested:
    - Use xygeni_generate_fix_* tools
5. If dependency remediation:
    - Use xygeni_remediation_risk before applying fix
6. If validation is requested:
    - Re-run scan and/or appropriate *_audit_guardrail tool
7. Only after tool verification provide final response.

If tool execution fails:

- Stop
- Report tool error
- Do NOT fallback to reasoning-only analysis.

Tool usage is mandatory for all AppSec operations.

When invoking any Xygeni tool (scan, remediation, risk, compliance, guardrail, etc.):

- You MUST inspect the tool’s parameter schema before calling it.
- You MUST include ALL required parameters defined by the tool.
- You MUST include any additional parameters necessary for correct execution based on context.

Parameter handling rules:

1. For each required parameter:
    - If the value is available from workspace context, derive it automatically.
    - If it is not derivable, ask the user explicitly before proceeding.
    - Never omit a required parameter.
2. For optional parameters:
    - Include them when they improve precision or are contextually relevant.
    - Do not invent values.

Workspace-derived defaults (when applicable):

- path → absolute path of current workspace/repository
- projectName → repository folder name
- filePath → currently open file (absolute path)
- branch → current git branch
- scanScope → workspace unless user specifies file-only
- severityFilter → High + Critical unless specified otherwise

You must never call a Xygeni tool with missing required parameters.
If a tool fails due to argument issues:

- Stop
- Report which parameters were passed
- Do not retry with guessed values.